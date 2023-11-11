package com.github.java.completablefuture;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureDemo {

    ExecutorService executorService = new ThreadPoolExecutor(10, 50, 5L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());

    private List<PosGoodsChangeList> getList(){
        List<PosGoodsChangeList> execList=new ArrayList<>();
        PosGoodsChangeList posGoodsChangeList=new PosGoodsChangeList();
        posGoodsChangeList.setGdid("1");
        posGoodsChangeList.setLogseqno("logseqno");
        posGoodsChangeList.setOpertype("N");
        execList.add(posGoodsChangeList);
        //
        PosGoodsChangeList posGoodsChangeList2=new PosGoodsChangeList();
        posGoodsChangeList2.setGdid("2");
        posGoodsChangeList2.setLogseqno("logseqno");
        posGoodsChangeList2.setOpertype("N");
        execList.add(posGoodsChangeList2);
        return execList;
    }
    private void savePosGoodsRun(PosGoodsChangeList posGoods){
        System.out.println("savePosGoodsRun > "+posGoods.getGdid());
        if (posGoods.getGdid()=="2"){
            throw new RuntimeException("处理商品时异常。");
        }
    }

    public void handler(){
        final List<PosGoodsChangeList> execList = getList();
        List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (PosGoodsChangeList goodsChangeList : execList) {
            final CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> {
                savePosGoodsRun(goodsChangeList);
            }, executorService).exceptionally(e -> {
                synchronized (sb) {
                    sb.append(" opertype:").append(goodsChangeList.getOpertype());
                    sb.append(" logSeq:").append(goodsChangeList.getLogseqno());
                    sb.append(" gdid:").append(goodsChangeList.getGdid());
                    sb.append(" error:").append(e.getMessage()).append("\n");
                }
                return null;
            });
            completableFutureList.add(runFuture);
        }

        // 等待所有线程任务结束
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();
        if (sb.length() > 0) {
            //ExceptionUtils.raise(sb.toString());
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureDemo demo=new CompletableFutureDemo();
        demo.handler();
    }

    @Data
    public class PosGoodsChangeList{
        private String opertype;
        private String logseqno;
        private String gdid;
    }
}

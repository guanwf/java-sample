package com.github.java.runoob.generics;

import java.util.List;

public interface IGenerics {

    <E> List<E> selectList(String statement, Object parameter);

}

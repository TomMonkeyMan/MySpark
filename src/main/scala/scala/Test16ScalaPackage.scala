package scala

/**
  * Created by jiangzl on 2016/10/20.
  */


//// 串联使用,例如： a.b.c.d
//package cn.test
//// 顶部标记
//package com.test
//package cn
//// 包的使用
//package aa.bb.cc.dd

// 设置包的级别, 新建
//class XXX{
//  //私有变量的使用的不同 包的级别
//  private[aa] def xxa = {}
//  private[bb] def xxb = {}
//  private[cc] def xxc = {}
//  private[dd] def xxd = {}
//}

//package object Test16ScalaPackage {
//  def main(args: Array[String]) {
//    println("ApacheCN")
//  }
//}

// 包对象
object Test16ScalaPackage {
    def main(args: Array[String]) {
      println("ApacheCN")
    }
  }

// 引入 并 重命名
import java.util.{HashMap => JavaHashMap}
// 引入 并 隐藏方法 他人无法调用，逗号后面接导入的对象 _ 表示所有的
import java.util.{HashMap => _}
// 引入所有的成员

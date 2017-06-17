package org.es.framework.util

import java.io.{File, FileInputStream, InputStream}

import org.apache.poi.{POIXMLDocument, POIXMLTextExtractor}
import org.apache.poi.hwpf.extractor.WordExtractor
import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.xwpf.extractor.XWPFWordExtractor

/**
  * Created by mick.yi on 2017/6/17.
  * POI读写word工具类
  */
object POIUtil {
  /**
    * 从word读取文字
    * @param filePath 文件路径名
    * @return word中的文本
    */
  def readFromWord(filePath:String):String={
   //通过文件名判断word2003还是2007
    if(filePath.endsWith("doc"))
      readFromWord2003(filePath)
    else
      readFromWord2007(filePath)
  }
  private def readFromWord2003(filePath:String):String={
    val is: InputStream = new FileInputStream(filePath)
    val ex: WordExtractor = new WordExtractor(is)
    ex.getText.trim
  }

  private def readFromWord2007(filePath:String):String={
    val opcPackage: OPCPackage = POIXMLDocument.openPackage(filePath)
    val extractor: POIXMLTextExtractor = new XWPFWordExtractor(opcPackage)
    extractor.getText.trim
  }

}

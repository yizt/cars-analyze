package org.es.cars

import java.io.{File, FileInputStream, InputStream}

import org.apache.poi.{POIXMLDocument, POIXMLTextExtractor}
import org.apache.poi.hwpf.extractor.WordExtractor
import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.xwpf.extractor.XWPFWordExtractor

/**
* Created by mick.yi on 2017/6/16.
* POI抽取Word文本
*/
object PoiClient {
  def main(args: Array[String]) {
    val is: InputStream = new FileInputStream("D:\\esspace\\cars-analyze\\src\\main\\resources\\files\\0供电处关于7月24日大西高铁介休东变电所跳闸情况分析.doc")
    //val is: InputStream = new FileInputStream(new File("D:\\esspace\\cars-analyze\\src\\main\\resources\\2007.docx"))

    val ex: WordExtractor = new WordExtractor(is)
    val text2003: String = ex.getText
    System.out.println(text2003)

    val opcPackage: OPCPackage = POIXMLDocument.openPackage("D:\\esspace\\cars-analyze\\src\\main\\resources\\files\\2007.docx")
    val extractor: POIXMLTextExtractor = new XWPFWordExtractor(opcPackage)
    val text2007=extractor.getText()
    System.out.println(text2007)
  }
}

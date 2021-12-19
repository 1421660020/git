import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * @Author Administrator
 * @Date 2021/11/14 17:40
 * @Version 1.0
 */
public class Dom4jTest {
    public void test() throws DocumentException {
        SAXReader saxReader= new SAXReader();
        Document document=saxReader.read("xml/books.xml");

        System.out.println( document.getRootElement().element("book").asXML());
        //System.out.println(e);
    }

}

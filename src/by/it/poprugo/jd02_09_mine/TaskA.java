package by.it.poprugo.jd02_09_mine;

import by.it._examples_.jd01_11.Collections.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContent = JAXBContext.newInstance(Orders.class);
        Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
        //сначала было String xmlPath = System.getProperty("user.dir") + "/src/by/it/poprugo/jd02_07/Person+XSD.xml";
        String xmlSource = System.getProperty("user.dir") + "/src/by/it/poprugo/jd02_07/Person+XSD.xml";
        String xmlTarget = System.getProperty("user.dir") + "/src/by/it/poprugo/jd02_09/Person+XSD.xml";
        Orders persons = (Orders) unmarshaller.unmarshal(new File(xmlSource));//было File(xmlPath)
        //System.out.println(persons);
        Marshaller marshaller = jaxbContent.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(persons, System.out);
        // дальше - история с потоками: в try-catch и т.д.
        try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
            marshaller.marshal(persons, outputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
// поменяли вывод, впрочем первоначальный вариант вывода я не успела записать

        System.out.println(persons);


    }

}

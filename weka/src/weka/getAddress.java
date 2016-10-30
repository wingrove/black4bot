/**
 * Created by XIaofeng on 10/29/16.
 */
import java.io.*;

/**
 * Created by XIaofeng on 10/29/16.
 */
public class getAddress {

    public static void main(String[] args) {

        getAddress a = new getAddress();
        a.listFiles("/Users/XIaofeng/gasData");

    }

    public void listFiles(String directoryName){

        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                readTxt("/Users/XIaofeng/gasData/"+file.getName());
            }
        }
    }





    public static void readTxt(String filePath) {

        try {
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                int counter = 0;
                String address="";
                String fileName = file.getName();
                String sum = "";

                while ((lineTxt = br.readLine()) != null) {

                    counter++;
                    if (counter<5){
                        continue;
                    }


                    if(counter%4 == 3 || counter %4 == 0 ) {
                        address = address+ " "+lineTxt;
                        if(counter%4 == 3){

                        }else{
                            address =  address+"\n";

                        }

                    }


                }
                write("/Users/XIaofeng/gasData/recalAddress/"+fileName, address);

                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }

    }



    public static void write(String path, String content) {
        try {
            File f = new File(path);

            if (f.exists()) {
                System.out.println("文件存在");
            } else {
                System.out.println("文件不存在，正在创建...");
                if (f.createNewFile()) {
                    System.out.println("文件创建成功！");
                } else {
                    System.out.println("文件创建失败！");
                }
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(content);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

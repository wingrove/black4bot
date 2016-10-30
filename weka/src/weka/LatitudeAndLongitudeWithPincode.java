import java.io.*;


/**
 * This class will get the lat long values.
 */
public class LatitudeAndLongitudeWithPincode
{
    public static void main(String[] args) throws Exception
    {

        LatitudeAndLongitudeWithPincode a = new LatitudeAndLongitudeWithPincode();
        a.listFiles("/Users/XIaofeng/gasData/result/");


    }


    public void listFiles(String directoryName){

        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                readTxt("/Users/XIaofeng/gasData/result/"+file.getName());
            }
        }
    }


    public static void write(String path, String content) {
        try {
            File f = new File(path);

            if (f.exists()) {
                System.out.println("file exist");
            } else {
                System.out.println("file doesn't exist, create one...");
                if (f.createNewFile()) {
                    System.out.println("create file success！");
                } else {
                    System.out.println("create file fail！");
                }
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(content);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readTxt(String filePath) {

        try {
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                String sum = "";
                String fileName = file.getName();

                while ((lineTxt = br.readLine()) != null) {


                    String postcode = lineTxt;

                    sum =  sum + postcode+ " "+fileName.substring(0,5)+"\n";





                }

                write("/Users/XIaofeng/gasData/result/addzip/"+fileName, sum);
                br.close();
            } else {
                System.out.println("file doesn't exsit!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("read file wrong!");
        }

    }








}
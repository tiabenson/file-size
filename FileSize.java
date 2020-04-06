/*
Created by Tia Benson
*/

import java.io.File;

public class fileSize {

   static double total = 0.00; //sums all file sizes together

    public static void getFileSizes(File dir, double file_sum)
    {
        //listFiles() returns an array of file objects and all files/directories in current directory
        File[] files = dir.listFiles(); 
        
        for(int i = 0; i < files.length; i++) //loop through all contents of directory to find files
        {
            if(!(files[i].isDirectory())) //if a file 
            {
                file_sum = files[i].length();  //get size of file in bytes
                total += file_sum;  //sum total file sizes so far
                
                System.out.println("File: " + files[i].getName() + ", " + file_sum + " bytes");
            }
            
            else //if a subdirectory, recurse into that directory
            {
                dir = files[i];
                System.out.println("");
                System.out.println("Going to subdirectory " + dir);
                
                getFileSizes(dir, file_sum);
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        double file_sum = 0.00;
        
        String current_dir = new File("").getAbsolutePath();	 //get current directory
        File dir = new File(current_dir);   //create new file object to obtain all contents in directory
        
        System.out.println("");
        System.out.println("Current directory: " + dir);
        System.out.println("");
        
        getFileSizes(dir, file_sum); //get total file size
        
        double size_kb = total/1024;    //convert file size to kilobytes and megabytes
        double size_mb = size_kb/1024;
        
        System.out.println("");
        System.out.println("Total file size in bytes: " + String.format("%.2f", total));
        System.out.println("Total file size in kilobytes: " + String.format("%.2f", size_kb));
        System.out.println("Total file size in megabytes: " + String.format("%.2f", size_mb));
        
    }
    
}
    


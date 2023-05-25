
        import java.io.DataInputStream;
        import java.io.DataOutputStream;
        import java.io.EOFException;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.util.Scanner;


        public class BinaryDataIO2file
        {
            public static void main(String[] args)
            {
                // TODO code application logic here
                Scanner sc = new Scanner (System.in);
                DataOutputStream dos;
                try
                {
                    dos = new DataOutputStream(new FileOutputStream("student.dat"));
                    long crn;
                    float cgpa;
                    System.out.println("Enter CRN and CGPA: ");
                    for(int i = 0; i<3 ;i++)
                    {
                        crn = sc.nextLong();
                        cgpa = sc.nextFloat();
                        dos.writeLong(crn);
                        dos.writeFloat(cgpa);
                    }

                }catch (FileNotFoundException fnfe)
                {
                    System.out.println("File doesnt exist at location");
                }catch(IOException ioe){
                    System.out.println("IO error occured!");
                }
                DataInputStream dis;
                try
                {
                    dis = new DataInputStream(new FileInputStream("student.dat"));
                    System.out.println("\tCRN\t\tCGPA");
                    System.out.println("\t-------------");
                    while(true)
                    {
                        long tcrn = dis.readLong();
                        float tcgpa = dis.readFloat();
                        System.out.println("\t"+tcrn+"\t"+tcgpa);

                    }
                }catch(EOFException eofe){
                System.out.println("End of file reached");

                }catch(FileNotFoundException fnfe){
                System.out.println("File doesnt exist at location");
                }
                catch(IOException ioe){
                System.out.println("IO error occured");
                }
            }
        }

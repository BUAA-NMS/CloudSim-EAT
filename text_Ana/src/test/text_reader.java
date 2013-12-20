package test;


import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Date;

public class text_reader {

	/**
	 * @param args
	 */
	static double a[] = new double[900];
	static double v[] = new double[900];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String path = "D://test//L";    
		 getFile(path);    
	}
	private static void getFile(String path){    
        // get file list where the path has    
        File file = new File(path);    
        // get the folder list    
        File[] array = file.listFiles();
        
           
        for(int i=0;i<array.length;i++){    
            if(array[i].isFile()){    
                // only take file name    
                //System.out.println("^^^^^" + array[i].getName());    
                // take file path and name    
                //System.out.println("#####" + array[i]);    
                // take file path and name    
                System.out.println("*****" + array[i].getPath());    
                double tem = 0;
				tem = calculate_Ave(array[i].getPath());
				System.out.println(tem);
				PrintWriter pw1 = null;
				PrintWriter pw2 = null;
				try {
					pw1 = new PrintWriter(new FileWriter("D://test//a.txt",true),true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw1.println(Double.toString(tem));
				a[i] = tem;
				v[i] = findfangcha(array[i].getPath(),i);
				System.out.println(v[i]);
				try {
					pw1 = new PrintWriter(new FileWriter("D://test//v.txt",true),true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw1.println(Double.toString(v[i]));
                classify(tem,array[i].getPath(),array[i].getName());
                classify2(v[i],array[i].getPath(),array[i].getName());
                
            }else if(array[i].isDirectory()){    
                getFile(array[i].getPath());    
            }    
        }    
    } 
	
	
	private static int calculate_Ave(String filepath)
	{
		int count=1,sum = 0;
		File file = new File(filepath);
		Reader reader = null;
		int tem = 0;
		
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    BufferedReader br = new BufferedReader(fr);
	        String data = "0";
	        String[] temp = null;
	        
	        try {
				while ((data = br.readLine()) != null) {
					tem = Integer.parseInt(data);
				//	System.out.println(count+"    "+tem);
					count++;
					sum=sum+tem;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return sum/count;
	}
	
	
	
	
	
	private static void classify(double flag, String Path, String name)
	{
		
		if(flag<0)
			;
		else if(flag<=15)
			try {
				forTransfer(Path,"D://test//destination//L//"+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(flag>=16&&flag<=48)
			try {
				forTransfer(Path,"D://test//destination//M//"+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				forTransfer(Path,"D://test//destination//H//"+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	private static void classify2(double flag, String Path, String name)
	{
		
		if(flag<0)
			;
		else if(flag<=120)
			try {
				forTransfer(Path,"D://test//destination//L//VL//"+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				forTransfer(Path,"D://test//destination//L//VH//"+name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static long forTransfer(String P1,String P2) throws Exception{
        long time=new Date().getTime();
        File f1 = new File(P1);
		File f2 = new File(P2);
        int length=2097152;
        FileInputStream in=new FileInputStream(f1);
        FileOutputStream out=new FileOutputStream(f2);
        FileChannel inC=in.getChannel();
        FileChannel outC=out.getChannel();
        int i=0;
        while(true){
            if(inC.position()==inC.size()){
                inC.close();
                outC.close();
                return new Date().getTime()-time;
            }
            if((inC.size()-inC.position())<20971520)
                length=(int)(inC.size()-inC.position());
            else
                length=20971520;
            inC.transferTo(inC.position(),length,outC);
            inC.position(inC.position()+length);
            i++;
        }
    }
	
	
	public static double findfangcha(String path,int i)
	{
		/*int count=1;
		double sum = 0;
		File file = new File(path);
		Reader reader = null;
		try
		{
			reader = new InputStreamReader(new FileInputStream(file));
			int temp;
			while((temp = reader.read()) != -1)
			{
				if (((int) temp) != '\r') 
				{
					System.out.println(count+"    "+temp);
					count++;
					sum=sum+Math.pow(temp-a[i],2);
				}

			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return sum/count;*/
		int count=1;
		double sum = 0;
		File file = new File(path);
		Reader reader = null;
		int tem = 0;
		
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    BufferedReader br = new BufferedReader(fr);
	        String data = "0";
	        String[] temp = null;
	        
	        try {
				while ((data = br.readLine()) != null) {
					tem = Integer.parseInt(data);
				//	System.out.println(count+"    "+tem);
					count++;
					sum=sum+Math.pow(tem-a[i],2);
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return sum/count;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void deletefile(String fileName)
	{
		
	}
	
	
	static double sumfile(String filename) throws IOException {  
	    Reader r = new BufferedReader(new FileReader(filename));  
	    StreamTokenizer stok = new StreamTokenizer(r);  
	    stok.parseNumbers();  
	    double sum = 0;
	    int count = 1;
	    int max = 0;
	    stok.nextToken();  
	    while (stok.ttype != StreamTokenizer.TT_EOF) {  
	      if (stok.ttype == StreamTokenizer.TT_NUMBER)  
	        {
	    	  System.out.println(count+"    "+stok.nval);
	    	  sum += stok.nval;
	    	  count++;
	    	  int t=stok.ttype;
	    	  int d[] = new int[10];
	    	  int c[] = new int[10];
	    	  int s[] = new int[4];
	    	  switch(t/10)
	    	  {
	    	  case 0: d[0]+=t;c[0]++;
	    	  case 1: d[1]+=t;c[1]++;
	    	  case 2: d[2]+=t;c[2]++;
	    	  case 3: d[3]+=t;c[3]++;
	    	  case 4: d[4]+=t;c[4]++;
	    	  case 5: d[5]+=t;c[5]++;
	    	  case 6: d[6]+=t;c[6]++;
	    	  case 7: d[7]+=t;c[7]++;
	    	  case 8: d[8]+=t;c[8]++;
	    	  case 9: d[9]+=t;c[9]++;
	    	  default:;
	    	  }
	    	  for(int i=0;i<3;i++)
	    	  {
	    		  switch(i)
	    		  {
	    		  case 0:
	    			  for(int j=0;j<10;j++)
	    			  {
	    				  if(max<c[j])
	    				  {
	    					  max=c[j];
	    					  s[i]=j;
	    				  }
	    			  }
	    			  max=0;
	    		  case 1:
	    			  for(int j=0;j<10;j++)
	    			  {
	    				  if(max<c[j]&&j!=s[0])
	    				  {
	    					  max=c[j];
	    					  s[i]=j; 
	    				  }
	    			  }
	    		  case 2:
	    			  for(int j=0;j<10;j++)
	    			  {
	    				  if(max<c[j]&&j!=s[0]&&j!=s[1])
	    				  {
	    					  max=c[j];
	    					  s[i]=j; 
	    				  }
	    			  }
	    			  default:;
	    		  }
	    			  
	    	  }
	        }
	      else  
	        System.out.println("Nonnumber: " + stok.sval);  
	      stok.nextToken();  
	    }  
	    System.out.println("The file sum is " + sum);  
	    return sum/count;
	  }  
	public static int most_num(String filename) throws IOException
	{
		Reader r2 = null;
		r2 = new BufferedReader(new FileReader(filename));
	    StreamTokenizer stok2 = new StreamTokenizer(r2);  
	    stok2.parseNumbers();  
	    double sum = 0;
	    int count = 1;
	    int max = 0;
	    int d[] = new int[10];
	    int c[] = new int[10];
	    int s[] = new int[4];
		stok2.nextToken();
	    while (stok2.ttype != StreamTokenizer.TT_EOF) {  
	      if (stok2.ttype == StreamTokenizer.TT_NUMBER)  
	        {
	    	  count++;
	    	  int t=stok2.ttype;
	    	  switch(t/10)
	    	  {
	    	  case 0: d[0]+=t;c[0]++;
	    	  case 1: d[1]+=t;c[1]++;
	    	  case 2: d[2]+=t;c[2]++;
	    	  case 3: d[3]+=t;c[3]++;
	    	  case 4: d[4]+=t;c[4]++;
	    	  case 5: d[5]+=t;c[5]++;
	    	  case 6: d[6]+=t;c[6]++;
	    	  case 7: d[7]+=t;c[7]++;
	    	  case 8: d[8]+=t;c[8]++;
	    	  case 9: d[9]+=t;c[9]++;
	    	  default:;
	    	  }
	    	  for(int i=0;i<3;i++)
	    	  {
	    		  switch(i)
	    		  {
	    		  case 0:
	    			  for(int j=0;j<10;j++)
	    			  {
	    				  if(max<c[j])
	    				  {
	    					  max=c[j];
	    					  s[i]=j;
	    				  }
	    			  }
	    			  max=0;
	    		  case 1:
	    			  for(int j=0;j<10;j++)
	    			  {
	    				  if(max<c[j]&&j!=s[0])
	    				  {
	    					  max=c[j];
	    					  s[i]=j; 
	    				  }
	    			  }
	    		  case 2:
	    			  for(int j=0;j<10;j++)
	    			  {
	    				  if(max<c[j]&&j!=s[0]&&j!=s[1])
	    				  {
	    					  max=c[j];
	    					  s[i]=j; 
	    				  }
	    			  }
	    			  default:;
	    		  }
	    			  
	    	  }
	        }
	      else  
	        System.out.println("Nonnumber: " + stok2.sval);  
	      stok2.nextToken();  
	    }  
	    System.out.println("The file sum is " + sum);
		int ss = s[0]+s[1]+s[2];
		int sum2 = d[s[0]]+d[s[1]]+d[s[2]];
		return sum2/ss;
	  }  
	

}

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
//import java.sql.*;
import java.time.*;
import java.text.SimpleDateFormat; 

public class Notepad_edit extends KeyAdapter  implements ActionListener, KeyListener
{
	
	static int active =0;
	static int fsize=17;
	
	JFrame frame1;
	JMenuBar npMenuBar;
	JMenu file, edit, format, view ,textSum,align ,advance;
	JMenuItem newdoc, opendoc, exit, savedoc, saveasdoc, copydoc, pastedoc, 
              remdoc,    fontfamily, fontstyle, fontsize, status ,back_color,text_color,date,
                 time,duration ,left,right,center,text_sum;
	JTextArea maintext;
	JTextField title;
	Font font1;
	JPanel bottom;
	JLabel details, pastecopydoc;
	JList familylist, stylelist, sizelist;
	JScrollPane sb;
              JScrollPane sp;

	String familyvalue[]={"Agency FB","Antiqua","Architect","Arial","Calibri","Comic Sans","Courier","Cursive","Impact","Serif"};
	String sizevalue[]={"5","10","15","20","25","30","35","40","45","50","55","60","65","70"};
	int [] stylevalue={ Font.PLAIN, Font.BOLD, Font.ITALIC };
	String [] stylevalues={ "PLAIN", "BOLD", "ITALIC" };
	String ffamily, fsizestr, fstylestr;
	int fstyle;
	int cl;
	int linecount;
	String tle ,texts;
	String topicstitle = "";
	  long start_time = System.currentTimeMillis();
    FileDialog fd1;

Notepad_edit(){

	frame1 = new JFrame("My First Notepad ");

	font1=new Font("Arial",Font.PLAIN,17);

	bottom = new JPanel();
	details = new JLabel();
	pastecopydoc = new JLabel();

	familylist = new JList(familyvalue);
	stylelist = new JList(stylevalues);
	sizelist = new JList(sizevalue);


	familylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	sizelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	stylelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	bottom.add(details);

	maintext = new JTextArea();

	sp=new JScrollPane(maintext);
	title = new JTextField(100);

	sb = new JScrollPane(maintext);

	maintext.setMargin( new Insets(5,5,5,5) );

	maintext.setFont(font1);
	frame1.add(maintext);

	npMenuBar = new JMenuBar();

	file = new JMenu("File");
	edit = new JMenu("Edit");
	format = new JMenu("Format");
	view = new JMenu("View");
            textSum = new JMenu("textSum");
       advance = new JMenu("advance");
   align= new JMenu("align");



	newdoc = new JMenuItem("New Document");
	opendoc = new JMenuItem("Open Document");
	savedoc = new JMenuItem("Save Document");
	saveasdoc = new JMenuItem("Save As Document");
	exit = new JMenuItem("Exit");
	copydoc = new JMenuItem("Copy Document");
	remdoc = new JMenuItem("Remove Document");
	pastedoc = new JMenuItem("Paste Document");

    back_color = new JMenuItem(" back_color");
    text_color = new JMenuItem("text_color");
    date = new JMenuItem("date");
    time = new JMenuItem("time");
    duration = new JMenuItem("duration");
   left = new JMenuItem("left");
   right = new JMenuItem("right");
     center = new JMenuItem("center");
  text_sum = new JMenuItem("text_sum");

   		

	fontfamily = new JMenuItem("Set Font Family");
	fontstyle = new JMenuItem("Set Font Style");
	fontsize = new JMenuItem("Set Font Size");
     //color  	 

    status = new JMenuItem("Status");

	file.add(newdoc);
	file.add(opendoc);
	file.add(savedoc);
	file.add(saveasdoc);
	file.add(exit);

	edit.add(copydoc);
	edit.add(pastedoc);
	edit.add(remdoc);

	format.add(fontfamily);
	format.add(fontstyle);
	format.add(fontsize);

	view.add(status);

                advance.add( date);
                advance.add( time);
                advance.add( duration);
             advance.add( text_color);
             advance.add( back_color);

                align.add( left);
                align.add(right);
                align.add(center);


              textSum.add(text_sum);

	npMenuBar.add(file);
	npMenuBar.add(edit);
	npMenuBar.add(format);
	npMenuBar.add(view);
            npMenuBar.add(advance);
          npMenuBar.add(align);
        npMenuBar.add(textSum);

	frame1.setJMenuBar(npMenuBar);
	frame1.add(bottom, BorderLayout.SOUTH);

              opendoc.addActionListener(this);
	newdoc.addActionListener(this);
	copydoc.addActionListener(this);
	pastedoc.addActionListener(this);
	remdoc.addActionListener(this);
	status.addActionListener(this);
	savedoc.addActionListener(this);
	saveasdoc.addActionListener(this);


   fontfamily.addActionListener(this);
fontstyle.addActionListener(this);
fontsize.addActionListener(this);


          back_color.addActionListener(this);
       text_color.addActionListener(this);
       date.addActionListener(this);
          time.addActionListener(this);
        duration.addActionListener(this);


         left.addActionListener(this);
         right.addActionListener(this);
      center.addActionListener(this);

          text_sum.addActionListener(this);




	fontfamily.addActionListener(this);
	fontsize.addActionListener(this);
	fontstyle.addActionListener(this);

	exit.addActionListener(this);

	maintext.addKeyListener(this);

	frame1.setSize(650,650);     
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setLocationRelativeTo(null);
	frame1.setVisible(true);

              maintext.setBackground(Color.WHITE);
    //fame bakground color

}
public void actionPerformed(ActionEvent ae)
{       
	if(ae.getSource()== newdoc)
	{
	frame1.setTitle("My New Document");
	maintext.setText("");
	title.setText("");
	}
                else if(ae.getSource()==date)
	{    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                   Date date = new Date();
                 System.out.println(sdf.format(date));
                  JOptionPane.showMessageDialog(null, "Current Date and Time "+sdf.format(date));
               }
	
             else if(ae.getSource()== time)
	{
                     System.out.println(java.time.LocalTime.now());  
                    JOptionPane.showMessageDialog(null, "Current  Time "+java.time.LocalTime.now());

               }

           else if(ae.getSource()== back_color)
	{          Random r = new Random();

     Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));

       maintext.setBackground(c);

               }

          else if(ae.getSource()== text_color)
	{      Random r = new Random();  
                 Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
             maintext. setForeground(c);

               }
               else if(ae.getSource()== duration)
	{   long end_time = System.currentTimeMillis();  
             long difference = end_time-start_time;
            JOptionPane.showMessageDialog(null, "Duration of Time "+difference);
               }
               else if(ae.getSource()== left)
	{     maintext.setAlignmentX(TextArea.LEFT_ALIGNMENT);

               }
                else if(ae.getSource()== right)
	{    //  maintext.setRTL(true); 
                    maintext.setAlignmentX(TextArea.RIGHT_ALIGNMENT);
                 //  textArea.setAlignment(RIGHT);

               }
                else if(ae.getSource()== center)
	{   // maintext.setAlignmentX(CENTRE);

               }
               else if(ae.getSource()== text_sum)
	{     String txt=maintext.getText();
                int count=0;
           StringTokenizer stk=new StringTokenizer(txt," ");
             while(stk.hasMoreTokens())
                      {
          String token=stk.nextToken();
          count++;
       }
         String  ct=Integer.toString(count);;
      JOptionPane.showMessageDialog(null, "Count of Words is "+ct);
               }

	else if (ae.getSource()== copydoc)
	{
		String texts= maintext.getText();
		//pastecopydoc.setText(texts);
		JOptionPane.showMessageDialog(null, "Copied Text "+texts);
	}
	else if(ae.getSource()== remdoc)
	{
		maintext.setText("");
		JOptionPane.showMessageDialog(null, "Removed");
	}
	else if (ae.getSource() == pastedoc)
	{
		//if(maintext.getText().length() != 0)
		{
			maintext.setText(texts);
		}
		//else
		{
		//maintext.setText(pastecopydoc.getText());
		}
	}
	else if(ae.getSource()== status)
	{
		try{
			if(active==0)
			{
				File f = new File(tle+".txt");
				details.setText("Size: "+f.length());
			}
		}
		catch (Exception e)
		{
			
		}
	}
	else if (ae.getSource()== fontfamily)
		{

	    JOptionPane.showConfirmDialog(null, familylist, "Choose Font Family", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
              ffamily=String.valueOf(familylist.getSelectedValue());
		font1=new Font(ffamily,fstyle,fsize);
		maintext.setFont(font1);
		}
	else if (ae.getSource()== fontstyle)
		{

	    JOptionPane.showConfirmDialog(null, stylelist, "Choose Font Style", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		fstyle=stylevalue[stylelist.getSelectedIndex()];
		font1=new Font(ffamily,fstyle,fsize);
		maintext.setFont(font1);
		}
	else if (ae.getSource()== fontsize)
		{

	    JOptionPane.showConfirmDialog(null, sizelist, "Choose Font Size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		fsizestr=String.valueOf(sizelist.getSelectedValue());
		fsize =Integer.parseInt(fsizestr);
		font1=new Font(ffamily,fstyle,fsize);
		maintext.setFont(font1);
		}
	else if(ae.getSource()==exit)
		{
			frame1.dispose();
		}
	else if (ae.getSource()==savedoc)
	{
		title.setText(topicstitle);  
		tle= title.getText();
		try{
	    FileOutputStream filesave= new FileOutputStream(topicstitle+".txt");
		String s= maintext.getText();
		for(int i=0;i<s.length();i++)
		{
		  filesave.write(s.charAt(i));
		}
		filesave.close();
		}
		catch (Exception e){
			
		}
	}
	else if (ae.getSource()==saveasdoc)
	{
		if(title.getText().length() == 0)
	    {
topicstitle = JOptionPane.showInputDialog(null,  "Enter Your File Title?",
				"Your File Name",
               JOptionPane.QUESTION_MESSAGE);
				
	  title.setText(topicstitle);  
		tle= title.getText();
		try{
 FileOutputStream filesave= new FileOutputStream(tle+".txt");
		String s= maintext.getText();
		for(int i=0;i<s.length();i++)
		{
		  frame1.setTitle(topicstitle+".txt");
		  filesave.write(s.charAt(i));
		}
		filesave.close();
		}
		catch (Exception e){   }
		}
	}
	else if (ae.getSource()== opendoc)
	{ 

   try
 {
        FileReader reader =null;
;
       JFileChooser fileChooser= new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
int result = fileChooser.showOpenDialog(frame1);
if (result == JFileChooser.APPROVE_OPTION) {
   File selectedFile = fileChooser.getSelectedFile();
    if (selectedFile.canRead() && selectedFile.exists())
     {
      reader = new FileReader(selectedFile);
     }
     }

   BufferedReader in = new BufferedReader(reader);

   //inputLine recieves file text
   String inputLine = in.readLine();
   int LineNumber = 0;  
    while(inputLine!=null)
   { //LineNumber isn't needed, but it adds a line count on the left, nice
     LineNumber++;
   StringTokenizer tokenizer = new StringTokenizer(inputLine);

     //displays text file
     maintext.append(LineNumber+": "+inputLine+"\n");
     //next line in File opened
     inputLine = in.readLine();
   }
   //close stream, files stops loading
   in.close();
  }  
catch(IOException ex)
 {
   maintext.append("Error Processing File:\n" + ex.getMessage()+"\n");
 }
 //catches nullpointer exception, file not found
 catch(NullPointerException ex)
 {
   maintext.append("Open File Cancelled:\n" + ex.getMessage()+"\n");
 }

 }
}	

public void keyTyped(KeyEvent ke)
{
	cl= maintext.getText().length()+1;
	linecount = maintext.getLineCount();
	details.setText("Length: "+cl+" Line: "+linecount);
}		

public static void main(String ar[]) 
{
new Notepad_edit();
}

}


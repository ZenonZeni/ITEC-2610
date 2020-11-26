package A2;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * BookListWindow
 * @edited by: Christopher Nguyen
 * A2
 * @date: 11/14/2019
 */
public class BookListWindow extends JFrame implements ActionListener {
    /**
	 * 
	 */
	//======== Top ========
    private JPanel topPanel;
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton clearButton;

    //======== Middle ========
    private JScrollPane titleListScrollPane;
    private JList<String> bookTitleList;

    //======== Bottom ========
    private JPanel bottomPanel;
    private JButton addButton;
    private JButton detailButton;
    private JButton removeButton;

    //======== Data ========
    private BookStorage bookStorage1;
    private BookArrayModel bookListModel;

    public BookListWindow(BookStorage bookStorage) {
        this.bookStorage1 = bookStorage;
        bookListModel = new BookArrayModel(bookStorage.getAll());
        initComponents();
    }

    /**
     * Clears the search results and list all the books.
     */
    public void resetToAll() {
        bookListModel.setBookArray(bookStorage1.getAll());
        searchTextField.setText("");
        bookTitleList.updateUI();
    }

    /**
     * Returns the book storage.
     */
    public BookStorage getBookStorage() {
        return bookStorage1;
    }

    /**
     * Initializes the components.
     */
    private void initComponents() {
        Container contentPane = getContentPane();
        this.setTitle("Book Management");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //======== Top ========
        topPanel = new JPanel();
        searchTextField = new JTextField();
        searchButton = new JButton("SEARCH");
        clearButton = new JButton("CLEAR");

        searchButton.addActionListener(this);
        clearButton.addActionListener(this);

        {
            // Set the layout for topPanel and add the buttons.
            // TODO Add your code here...
        	topPanel.setLayout(new GridLayout(1,3));
        	topPanel.add(searchTextField);
        	topPanel.add(searchButton);
        	topPanel.add(clearButton);

        }

        //======== Middle ========
        titleListScrollPane = new JScrollPane();
        bookTitleList = new JList<>();

        {
            // Configure the bookTitleList 1) Use single selection
            //TODO Add your code here...
        	bookTitleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        	
        	//When Program starts it will list all Titles in the middle
       	  	String[] temp = new String [bookListModel.getSize()];
       	  	for (int i =0; i <bookListModel.getSize() ; i++ ) {
       	  		if(bookListModel.getElementAt(i)== null) {
       	  			continue;
       	  		}
       	  		else {
       	  			temp[i]= bookListModel.getElementAt(i);
       	  		}
     		}
     		bookTitleList.setListData(temp);
     		bookTitleList.updateUI();

        }

        titleListScrollPane.setViewportView(bookTitleList);

        //======== Bottom ========
        bottomPanel = new JPanel();
        addButton = new JButton("ADD");
        detailButton = new JButton("DETAIL");
        removeButton = new JButton("REMOVE");

        addButton.addActionListener(this);
        detailButton.addActionListener(this);
        removeButton.addActionListener(this);

        {
            // Set the layout for bottomPanel and add the buttons.
            // TODO Add your code here...
        	bottomPanel.setLayout(new GridLayout(1,3));
            bottomPanel.add(addButton);
            bottomPanel.add(detailButton);
            bottomPanel.add(removeButton);

        }

        contentPane.setLayout(new BorderLayout());
        {
            // Add the components to contentPane with proper layout options.
            // TODO Add your code here...
        	contentPane.add(topPanel, BorderLayout.NORTH);
        	contentPane.add(titleListScrollPane, BorderLayout.CENTER);
        	contentPane.add(bottomPanel, BorderLayout.SOUTH);

        }

        pack();
        setLocationRelativeTo(getOwner());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	//Searches through the array and outputs desired book based off keyword. Also you can use getAll to display all books
       if (e.getSource() == searchButton) {
           // Action for the SEARCH button
    	  String getValue = searchTextField.getText();
    	  String[] temp = new String [bookListModel.getSize()];
    	  Book titleMatch = bookStorage1.getByTitle(getValue);
    	  Book[] b = bookStorage1.titleSearch(getValue);
    	  
    	  if (getValue.equalsIgnoreCase("getAll")) {
    		  for (int i =0; i <bookListModel.getSize() ; i++ ) {
    			if(bookListModel.getElementAt(i)== null) {
    				continue;
    			}
    			else {
    			temp[i]= bookListModel.getElementAt(i);
    			}
    		  }
    		  bookTitleList.setListData(temp);
    		  bookTitleList.updateUI();
    	  }
    	  else if(!((b)== null)){
    		  for (int i =0; i <b.length-1 ; i++ ) {
      			if(b[i]== null) {
      				continue;
      			}
      			else {
      			temp[i]= b[i].getTitle();
      			}
      		  }
      		  bookTitleList.setListData(temp);
      		  bookTitleList.updateUI();
    	  }
    	  else if(getValue.equalsIgnoreCase((titleMatch.getTitle()))){
    		  String[] tMatch = {titleMatch.getTitle()};
    		  bookTitleList.setListData(tMatch);
    		  bookTitleList.updateUI();
    	  }
    	  
    	  else {
    		  JOptionPane.showMessageDialog(this, "Book does not exist");
    	  }
    		  
    	  
    	  //Clears the J List and re-list all books
       } else if (e.getSource() == clearButton) {
           // Action for the CLEAR button
    	  String[] temp =  {};
    	  bookTitleList.setListData(temp);
    	  resetToAll();
    	  temp = new String [bookListModel.getSize()];
    	  for (int i =0; i <bookListModel.getSize() ; i++ ) {
  			if(bookListModel.getElementAt(i)== null) {
  				continue;
  			}
  			else {
  			temp[i]= bookListModel.getElementAt(i);
  			}
  		  }
  		  bookTitleList.setListData(temp);
  		  bookTitleList.updateUI();
  		  searchTextField.setText("");
  		  
    	  
    	  //adds a new book into the array and reset text field
       } else if (e.getSource() == addButton) {
           // Action for the ADD button
    	   AddBookDialog dialog = new AddBookDialog(this);
    	   dialog.setVisible(true);
     	   resetToAll();
     	   String[] temp =  {};
     	   temp = new String [bookListModel.getSize()];
     	   for (int i =0; i <bookListModel.getSize() ; i++ ) {
  			if(bookListModel.getElementAt(i)== null) {
  				continue;
  			}
  			else {
  			temp[i]= bookListModel.getElementAt(i);
  			}
  		  }
    	  bookTitleList.setListData(temp);
     	   
    	  //Used to check details of book or update a book
       } else if (e.getSource() == detailButton) {
           // Action for the DETAIL button
    	   if(!(bookTitleList.getSelectedValue() == null)) {
    	   Book b = null;
    	   String t = bookTitleList.getSelectedValue();
    	   b= bookStorage1.getByTitle(t);
    	   UpdateBookDialog dialog = new UpdateBookDialog(this);
    	   dialog.showBook(b);
    	   }
    	   else {
    		   JOptionPane.showMessageDialog(this, "Please click on a book before you click on Details");
    	   }
    	   
    	   //Removes a selected J List value from the array 
       } else if (e.getSource() == removeButton) {
           // Action for the REMOVE button
           if (!bookTitleList.isSelectionEmpty()) {
               bookStorage1.remove(bookTitleList.getSelectedValue());
               JOptionPane.showMessageDialog(this, "Remove Successful!");
               resetToAll();
               String[] temp =  {};
               temp = new String [bookListModel.getSize()];
         	  	for (int i =0; i <bookListModel.getSize() ; i++ ) {
       			if(bookListModel.getElementAt(i)== null) {
       				continue;
       			}
       			else {
       			temp[i]= bookListModel.getElementAt(i);
       			}
       		  }
         	  bookTitleList.setListData(temp);
           }
       }
    }
    public static void main(String[] args) {
		BookStorage bookStore = new BookStorage();
        bookStore.initBooks();
        BookListWindow bookListWindow = new BookListWindow(bookStore);
        bookListWindow.setVisible(true);

	}
}


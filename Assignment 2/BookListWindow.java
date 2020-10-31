package a2;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import a2.Book.BookCategory;

/**
 * BookListWindow
 */
public class BookListWindow extends JFrame implements ActionListener {

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
    private BookStorage bookStorage;
    private BookArrayModel bookListModel;

    public BookListWindow(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
        bookListModel = new BookArrayModel(bookStorage.getAll());
        initComponents();
    }

    /**
     * Clears the search results and list all the books.
     */
    public void resetToAll() {
        bookListModel.setBookArray(bookStorage.getAll());
        searchTextField.setText("");
        bookTitleList.updateUI();
    }

    /**
     * Returns the book storage.
     */
    public BookStorage getBookStorage() {
        return bookStorage;
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
       if (e.getSource() == searchButton) {
           // Action for the SEARCH button
           // TODO Add your code here...
    	  String getValue = searchTextField.getText();
    	  String[] temp = new String [bookListModel.getSize()];
    	  Book titleMatch = bookStorage.getByTitle(getValue);
    	  Book[] b = bookStorage.titleSearch(getValue);
    	  if (getValue.equalsIgnoreCase( "all")) {
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
    		  for (int i =0; i <b.length ; i++ ) {
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
    	  else if(titleMatch == null) {
    		  System.out.println("No match");
    	  }
    	  else if(getValue.equalsIgnoreCase((titleMatch.getTitle()))){
    		  String[] tMatch = {titleMatch.getTitle()};
    		  bookTitleList.setListData(tMatch);
    		  bookTitleList.updateUI();
    	  }
    	  else {
    		  System.out.println("No match");
    	  }
    		  
    	  

       } else if (e.getSource() == clearButton) {
           // Action for the CLEAR button
           // TODO Add your code here...
    	  String[] temp =  {};
    	  bookTitleList.setListData(temp);
 		  bookTitleList.updateUI();

       } else if (e.getSource() == addButton) {
           // Action for the ADD button
           // TODO Add your code here...
    	   Book b = new Book("", "", 0, BookCategory.Programming);
    	   UpdateBookDialog dialog = new UpdateBookDialog(this);
    	   dialog.showBook(b);
       } else if (e.getSource() == detailButton) {
           // Action for the DETAIL button
           // TODO Add your code here...
    	   if(!(bookTitleList.getSelectedValue() == null)) {
    	   Book b = null;
    	   String t = bookTitleList.getSelectedValue();
    	   System.out.println(t);
    	   b= bookStorage.getByTitle(t);
    	   UpdateBookDialog dialog = new UpdateBookDialog(this);
    	   dialog.showBook(b);
    	   }
    	   else {
    		   System.out.println("bookTitlelist is empty");
    	   }
    	   
       } else if (e.getSource() == removeButton) {
           // Action for the REMOVE button
           if (!bookTitleList.isSelectionEmpty()) {
               bookStorage.remove(bookTitleList.getSelectedValue());
               JOptionPane.showMessageDialog(this, "Remove Successful!");
               resetToAll();
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


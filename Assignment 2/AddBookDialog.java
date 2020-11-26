package A2;
/**
 * The dialog for adding a new book.
 * @edited by: Christopher Nguyen
 * A2
 * @date: 11/14/2019
 */

import javax.swing.JOptionPane;

public class AddBookDialog extends BookPropertyDialog {

    /**
	 * Constructor
	 * @param BookListWindow owner
	 */

	public AddBookDialog(BookListWindow owner) {
        super(owner, "Add Book");
    }

    @Override
    //adds a book to the array and also prompts a message if user enters a book that already exists.
    protected void doSave(Book book) {
    	String x = book.getTitle();
    	if(bookCollection.getByTitle(x)== null) {
    		bookCollection.add(book);
    	}
    	else if(x.equals(bookCollection.getByTitle(x).getTitle() )) {
    		JOptionPane.showMessageDialog( this, "You have named a book the same as another please delete one" );
    		bookCollection.add(book);
    	}
    	else {
    		bookCollection.add(book);
    	}
    }
}

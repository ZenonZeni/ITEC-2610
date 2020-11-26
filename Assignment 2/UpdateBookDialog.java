package A2;

/**
 * The dialog for updating a book.
 * @edited by: Christopher Nguyen
 * A2
 * @date: 11/14/2019
 */
public class UpdateBookDialog extends BookPropertyDialog {

    /**
	 * Constructor
	 */

	public UpdateBookDialog(BookListWindow owner) {
        super(owner, "Update Book");
        titleTextField.setEnabled(false);
        saveButton.setText("UPDATE");
    }

    /**
     * Initializes the text fields with the given book.
     * @param Book book
     */
    public void showBook(Book book) {
        // TODO Add your code here...
    	titleTextField.setText(book.getTitle());
    	authorsTextField.setText(book.getAuthors());
    	pagesTextField.setText(Integer.toString(book.getPages()));
    	if (book.getCategory()==Book.BookCategory.Programming) {
    		categoryComboBox.setSelectedIndex(0);
    	}
    	else if (book.getCategory()==Book.BookCategory.Database) {
    		categoryComboBox.setSelectedIndex(1);
    	}
    	else{
    		categoryComboBox.setSelectedIndex(2);
    	}
    	
    	this.setVisible(true);
    }

    @Override
    /**
     * @param Book book
     * note: calls a method to update the object with the give parama book
     */
    protected void doSave(Book book) {
    	bookCollection.update(book);
    	
    }
}

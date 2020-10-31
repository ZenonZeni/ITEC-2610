package a2;

import a2.Book.BookCategory;

/**
 * The dialog for updating a book.
 */
public class UpdateBookDialog extends BookPropertyDialog {

    public UpdateBookDialog(BookListWindow owner) {
        super(owner, "Update Book");
        titleTextField.setEnabled(false);
        saveButton.setText("UPDATE");
    }

    /**
     * Initializes the text fields with the given book.
     */
    public void showBook(Book book) {
        // TODO Add your code here...
    	titleTextField.setText(book.getTitle());
    	authorsTextField.setText(book.getAuthors());
    	pagesTextField.setText(Integer.toString(book.getPages()));
    	if (book.getCategory()==BookCategory.Programming) {
    		categoryComboBox.setSelectedIndex(0);
    	}
    	else if (book.getCategory()==BookCategory.Database) {
    		categoryComboBox.setSelectedIndex(1);
    	}
    	else{
    		categoryComboBox.setSelectedIndex(2);
    	}
    	this.setVisible(true);
    }

    @Override
    protected void doSave(Book book) {
        // TODO Add your code here...
    }
}

package a2;

import java.util.StringTokenizer;

import a2.Book.BookCategory;

/**
 * A collection of {@link Book}.
 */
public class BookStorage {
	

    private Book[] books = new Book[100];

    
    
    public BookStorage() {
    	initBooks();
    }

    /**
     * Initializes the book storage with some arbitrary book objects.
     */
    public void initBooks() {
        books[0] = new Book("1 Something","IDK",100,Book. BookCategory.Programming);
        books[1] = new Book("2 Hello","IDK",100,BookCategory.Programming);
        books[2] = new Book("3 World","IDK",100,BookCategory.Programming);
        books[3] = new Book("4 Testing","IDK",100,BookCategory.Programming);
        books[4] = new Book("5 Who","IDK",100,BookCategory.Programming);
        books[5] = new Book("6 Book","IDK",100,BookCategory.Programming);
        books[6] = new Book("7 Testing","IDK",100,BookCategory.Programming);
        books[7] = new Book("8 Testing","IDK",100,BookCategory.Programming);
        books[8] = new Book("9 Who Knows","IDK",100,BookCategory.Programming);
        books[9] = new Book("10 Y","IDK",100,BookCategory.Programming);
        books[10] = new Book("11 22","IDK",100,BookCategory.Programming);
        
    }

    /**
     * Uses the given book to update the existing book with the same title.
     */
    public void update(Book book) {
        // TODO Add your code here...
    	int i=0;
    	while(i<100) {
    		if (books[i]==null) {
    			i++;
    		}
    		else if(book.getTitle().equals(books[i].getTitle())) {
    			books[i].setTitle(book.getTitle());
    			books[i].setAuthors(book.getAuthors());
    			books[i].setPages(book.getPages());
    			books[i].setCategory(book.getCategory());
    			books= this.sortByTitle(books);
    			i = 100;
    		}
    		else {
    			i++;
    		}
    	}
    }

    /**
     * Removes a book by title.
     */
    public void remove(String bookTitle) {
    	int i=0;
    	while(i<100) {
    		if (books[i]==null) {
    			i++;
    		}
    		else if(bookTitle.equals(books[i].getTitle())) {
    			books[i]= null;
    			books= this.sortByTitle(books);
    			i = 100;
    		}
    		else {
    			i++;
    		}
    	}
    }

    /**
     * Adds a new book.
     */
    public void add(Book book) {
    	for(int i= 0;i<100; i++) {
    		if (books[i]==null) {
    			books[i]= book;
    			books = this.sortByTitle(books);
    			i= 100;
    		}
    		else {
    			continue;
    		}
    	}
    }

    /**
     * Gets a book by title.
     */
    public Book getByTitle(String title) {
    	Book temp= null;
    	for (int i =0; i<100 ; i++) {
    		if (books[i]==null) {
    			continue;
    		}
    		else if(title.equals(books[i].getTitle())) {
    			temp = books[i];
    		}
    		else {
    			continue;
    		}
    	}
        return temp;
    }

    /**
     * Searches for books whose title contains the keyword and returns them ordered by titles (in alphabet order).
     */
    public Book[] titleSearch(String keyword) {
    	String word1 = null;
		String word2 = null;
		String word3 = null;
    	Book[] temp = new Book[100];
    	int count = 0;
    		for (int i=0; i<100; i++) {
    			if(!(books[i]==null)) {
    				StringTokenizer tokenizer = new StringTokenizer(books[i].getTitle());
    				if(tokenizer.hasMoreTokens()){
    			      word1 = tokenizer.nextToken();      // get first word
    			    }
    				if(tokenizer.hasMoreTokens()){
    			      word2 = tokenizer.nextToken();      // get second word
    			    }
    				if(tokenizer.hasMoreTokens()){
    			      word3 = tokenizer.nextToken();      // get third word
    			    }
    			}
    			
    			if (books[i]== null) {
    				continue;
    			}
    			else if (keyword.equalsIgnoreCase(books[i].getTitle())) {
    				temp[count] = books[i];
    				count++;
    			}
    			else if (keyword.equalsIgnoreCase(word1)) {
    				temp[count] = books[i];
    				count++;
    			}
    			else if (keyword.equalsIgnoreCase(word2)) {
    				temp[count] = books[i];
    				count++;
    			}
    			else if (keyword.equalsIgnoreCase(word3)) {
    				temp[count] = books[i];
    				count++;
    			}
    			else {
    				continue;
    			}
    		}
        return temp;
    }

    /**
     * Returns all books sorted by their titles (in alphabet order).
     */
    public Book[] getAll() {
        // TODO Add your code here...
    	int count = 0;
    	for (int i=0; i<100; i++) {
    		if(books[i] instanceof Book) {
    			count++;
    		}
    	}
    	this.sortByTitle(books);
    	Book[] temp = new Book[count];
    	for (int i=0; i<count; i++) {
    		temp[i]= books[i];
    	}
        return temp;
    }

    /**
     * Sorts an array of books by their titles in alphabet order.
     */
    private Book[] sortByTitle(Book[] bookArray) {
        // TODO Add your code here...
    	Book temp;
    	for (int i = 0; i < 100; i++) 
        {
             for (int j = i + 1; j < 100; j++) {
            	 if (bookArray[j] == null) {
            		 continue;
            	 }
            	 else if (bookArray[i]== null && bookArray[j] instanceof Book) {
            		 temp = bookArray[i];
                     bookArray[i] = bookArray[j];
                     bookArray[j] = temp;
            	 }
            	 else if (bookArray[i].getTitle().compareTo(bookArray[j].getTitle())>0) 
                 {
                     temp = bookArray[i];
                     bookArray[i] = bookArray[j];
                     bookArray[j] = temp;
                 }
            	 else {
            		 continue;
            	 }
             }
         }
        return bookArray;
    }

}

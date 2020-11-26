
package A2;

import javax.swing.JOptionPane;


/**
 * A collection of {@link Book}.
 * @edited by: Christopher Nguyen
 * A2
 * @date: 11/14/2019
 */
public class BookStorage {
	
	//instance variable 
    private Book[] books = new Book[100];

    
    //Constuctor to initalize the object's array with 12 books 
    public BookStorage() {
    	initBooks();
    }

    /**
     * Initializes the book storage with some arbitrary book objects.
     */
    public void initBooks() {
        books[0] = new Book("Discovering Beyond","Christopher",100,Book.BookCategory.Programming);
        books[1] = new Book("How to build a computer","Christopher",200,Book.BookCategory.Database);
        books[2] = new Book("Why is life Hard","Christopher",300,Book.BookCategory.Programming);
        books[3] = new Book("I need a 90 or much higher","Christopher",50,Book.BookCategory.Design);
        books[4] = new Book("Took me two days","Christopher",100,Book.BookCategory.Programming);
        books[5] = new Book("One life and One curse","Christopher",10000,Book.BookCategory.Design);
        books[6] = new Book("Video games","Christopher",1,Book.BookCategory.Programming);
        books[7] = new Book("Java Programming","Christopher",1000,Book.BookCategory.Programming);
        books[8] = new Book("ITEC 2610","Christopher",500,Book.BookCategory.Database);
        books[9] = new Book("My hat","Christopher",15,Book.BookCategory.Programming);
        books[10] = new Book("The internet","Christopher",10000000,Book.BookCategory.Programming);
        books[11] = new Book("If you give me a great mark thanks :D ", "Christopher", 0 ,Book.BookCategory.Database);
        
    }

    /**
     * Uses the given book to update the existing book with the same title.
     * @param Book book
     */
    public void update(Book book) {
        // TODO Add your code here...
    	int i=0;
    	while(i<100) {
    		if (books[i]==null) {
    			i++;
    		}
    		else if(book.getTitle().equals(books[i].getTitle())) {
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
     * @parama String bookTitle
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
     * @param Book book
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
    	if(books[99] instanceof Book) {
    		JOptionPane.showMessageDialog( null, "The book collection or array is full, please delete a book to add another" );
    	}
    }

    /**
     * Gets a book by title.
     * @parma String title
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
     *@Studentnotes: This will split the title up to 10 words and finds one word to match the @parma keyword 
     *then it adds the book to the array that will be returned 
     *after searching for other possible books matching the keyword
     *at the end of the loop
     */
    public Book[] titleSearch(String keyword) {
    	Book[] temp = new Book[100];
    	String title;
    	int count = 0;
    		for (int i=0; i<100; i++) {
    			if(!(books[i]== null)) {
    				title = books[i].getTitle();
    				String[] words;
    				words = title.split(" ", 10);
    				if (words.length == 1) {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
    					}
    				}
    				else if (words.length == 2) {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
        					}
    					if (keyword.equalsIgnoreCase(words[1])) {
    						temp[count] = books[i];
    						count++;
        					}
    				}
    				else if (words.length == 3) {
    						if (keyword.equalsIgnoreCase(words[0])) {
    							temp[count] = books[i];
    							count++;
    						}
    						else if (keyword.equalsIgnoreCase(words[1])) {
    							temp[count] = books[i];
    							count++;
    						}
    						else if (keyword.equalsIgnoreCase(words[2])) {
    							temp[count] = books[i];
    							count++;
    						}
    				}
    				else if (words.length == 4) {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[1])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[2])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[3])) {
    						temp[count] = books[i];
    						count++;
    					}
    				}
    				else if (words.length == 5) {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[1])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[2])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[3])) {
    						temp[count] = books[i];
		    				count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[4])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    				}
    				else if (words.length == 6) {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[1])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[2])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[3])) {
    						temp[count] = books[i];
		    				count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[4])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[5])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    				}
    				else if (words.length == 7) {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[1])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[2])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[3])) {
    						temp[count] = books[i];
		    				count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[4])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[5])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[6])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    				}
    				else if (words.length == 8) {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[1])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[2])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[3])) {
    						temp[count] = books[i];
		    				count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[4])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[5])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[6])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[7])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    				}
    				else if (words.length == 9) {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[1])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[2])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[3])) {
    						temp[count] = books[i];
		    				count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[4])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[5])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[6])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[7])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[8])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    				}
    				else if (words.length == 10 || words.length>= 10) {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[1])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[2])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[3])) {
    						temp[count] = books[i];
		    				count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[4])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[5])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[6])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[7])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[8])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[9])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    				}
    				else {
    					if (keyword.equalsIgnoreCase(words[0])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[1])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[2])) {
    						temp[count] = books[i];
    						count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[3])) {
    						temp[count] = books[i];
		    				count++;
    					}
    					else if (keyword.equalsIgnoreCase(words[4])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[5])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[6])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[7])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[8])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    					else if (keyword.equalsIgnoreCase(words[9])) {
    						temp[count] = books[i];
	    					count++;
	    					}
    				}

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
     * @param Book[] bookArray
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
            	 else if (bookArray[i].getTitle().compareToIgnoreCase(bookArray[j].getTitle())>0) 
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

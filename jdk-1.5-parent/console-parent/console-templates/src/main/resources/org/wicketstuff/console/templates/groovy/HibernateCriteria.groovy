import org.wicketstuff.console.examples.hibernate.Book

def sf = application.hibernateSessionFactory
def s = sf.openSession()
def books = s.createCriteria(Book.class).list()
books.each {println it}
s.close()

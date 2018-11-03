package fr.d2factory.libraryapp.book;

public class ISBN {
    public long getIsbnCode() {
        return isbnCode;
    }

    public ISBN() {
    }

    public void setIsbnCode(long isbnCode) {
        this.isbnCode = isbnCode;
    }

    long isbnCode;

    public ISBN(long isbnCode) {
        this.isbnCode = isbnCode;
    }
}

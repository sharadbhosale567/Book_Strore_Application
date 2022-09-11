package com.bridgelabz.bookstoreapplication.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String bookName;
    private String bookAuthor;
    private String bookDescription;
    private String bookLogo;
    private int bookPrice;
    private int bookQuantity;
}

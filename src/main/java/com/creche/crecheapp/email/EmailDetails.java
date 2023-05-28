package com.creche.crecheapp.email;
// Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    // Java Program to Illustrate EmailDetails Class



// Class


        // Class data members
        private String recipient;
        private String msgBody;
        private String subject;
        private String attachment;
    }




package com.example.crm.service;
import com.example.crm.entity.Customer;
import com.example.crm.repository.CustomerRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CustomerService implements CustomerIService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        // Update other fields as needed

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailToCustomer(Customer customer, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(customer.getEmail());
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }


    public void generateUserPdf(Customer user, String filePath) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText("User Information");
            contentStream.newLine();
            contentStream.showText("Username: " + user.getUserName());
            contentStream.newLine();
            contentStream.showText("Full Name: " + user.getFirstName() + " " + user.getLastName());
            contentStream.newLine();
            contentStream.showText("Phone Number: " + user.getPhone());
            contentStream.newLine();
            contentStream.showText("Email: " + user.getEmail());
            contentStream.newLine();
            contentStream.showText("Birthdate: " + user.getBirthDate());
            contentStream.endText();
            contentStream.close();

            document.save(filePath);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling strategy
        }
    }
}
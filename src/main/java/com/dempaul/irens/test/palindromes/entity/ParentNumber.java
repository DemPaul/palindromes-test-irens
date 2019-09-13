package com.dempaul.irens.test.palindromes.entity;

import com.dempaul.irens.test.palindromes.constraint.Number;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "ParentNumber")
public class ParentNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @NotBlank(message = "This field is required!")
    @Number(message = "Enter numbers only!")
    @Column(name = "Value", nullable = false)
    private String value;

    @NotNull(message = "This field is required!")
    @Min(value = 1, message = "Enter a number greater than 0!")
    @Column(name = "Palindromes_Num", nullable = false)
    private Integer numberOfPalindromes;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> palindromes = new ArrayList<>();

    public ParentNumber() {
    }

    public ParentNumber(String value, Integer numberOfPalindromes) {
        this.value = value;
        this.numberOfPalindromes = numberOfPalindromes;
    }

    public String getMax() {
        return getPalindromes().stream()
                .max(Comparator.comparing(BigInteger::new))
                .orElse("");
    }

    public String getMin() {
        return getPalindromes().stream()
                .min(Comparator.comparing(BigInteger::new))
                .orElse("");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumberOfPalindromes() {
        return numberOfPalindromes;
    }

    public void setNumberOfPalindromes(Integer numberOfPalindromes) {
        this.numberOfPalindromes = numberOfPalindromes;
    }

    public List<String> getPalindromes() {
        return palindromes;
    }

    public void setPalindromes(List<String> palindromes) {
        this.palindromes = palindromes;
    }
}

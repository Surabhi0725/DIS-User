package sgsits.cse.dis.user.model;

import javax.persistence.*;

@Entity
@Table(name = "external_examiner")
public class ExternalExaminer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "mobile_no", nullable = false, unique = true)
  private Long mobileNo;

  @Column(name = "email_id", nullable = false, unique = true)
  private String emailId;

  @Column(name = "designation")
  private String designation;

  @Column(name = "bank_name")
  private String bankName;

  @Column(name = "branch_address")
  private String branchAddress;

  @Column(name = "account_number")
  private String AccountNumber;

  @Column(name = "ifsc_code")
  private String ifscCode;

  public ExternalExaminer() {
  }

  public ExternalExaminer(Long id, String name, Long mobileNo, String emailId, String designation,
          String bankName, String branchAddress, String accountNumber, String ifscCode) {
    this.id = id;
    this.name = name;
    this.mobileNo = mobileNo;
    this.emailId = emailId;
    this.designation = designation;
    this.bankName = bankName;
    this.branchAddress = branchAddress;
    AccountNumber = accountNumber;
    this.ifscCode = ifscCode;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(Long mobileNo) {
    this.mobileNo = mobileNo;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getBranchAddress() {
    return branchAddress;
  }

  public void setBranchAddress(String branchAddress) {
    this.branchAddress = branchAddress;
  }

  public String getAccountNumber() {
    return AccountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    AccountNumber = accountNumber;
  }

  public String getIfscCode() {
    return ifscCode;
  }

  public void setIfscCode(String ifscCode) {
    this.ifscCode = ifscCode;
  }
}

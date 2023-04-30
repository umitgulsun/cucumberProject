@den@hen
Feature: Vice Dean Ogretmen olusturabilmelidir

  Background: :Teacher olarak giris yapar
    Given Kullanici anasayfaya gider
    Given Kullanici Anasayfada logine tiklar
    Given "username" ve "password" girer
    Then  login tusuna tiklar


  Scenario Outline: Ogretmen bilgileri girilerek ogretmen olusturma negatif test
    Given Kullanici menu butonuna tiklar
    Given Kullanici ogretmen alanina tiklar
    Given "<dersler>" ve "<ders>"alanina ders bilgileri girer
    Given "<name>" alanina bilgileri girer
    Given "<surname>" alanina surname bilgileri girer
    Given "<email>" alanina email bilgileri girer
    Given "<danisman>" alanina danisman bilgileri girer
    Given "<birthplace>" alanina birthplace bilgileri girer
    Given "<gender>" alanina gender bilgileri girer
    Given "<birthday>" alanina birthday bilgileri girer
    Given "<phone>" alanina uc-uc-dort rakam seklinde bilgileri girer
    Given "<ssn>" alanina uc-iki-dort rakam seklinde bilgileri girer
    Given "<username>" alanina username bilgileri girer
    Given "<password>" alanina password bilgileri girer
    Then  submit tusuna tiklar
    Then  sayfayi "<ssn>" numarasına gore olusup olusmadıgını kontrol eder

    Examples:
      | dersler | name  | surname |email        | danisman | birthplace | gender | birthday   | phone        | ssn         | username | password |
      | JAVA   | kadir | olur    |harka@gmail  | danisma  | adana      | gender | 22.04.2000 | 475-8578874  | 899-25-8974 | umitg    | Pl123456 |
      | JAVA   | Fatih | kadar   |hogam@       | danisma  | adana      | gender | 22.04.2000 | 475-837-8874 | 89425-8974  | umitg    | Pl123456 |
      | JAVA   | umit  | halak   |ferfs@jaa    | danisma  | adana      | gender | 22.04.2000 | 275-855-8789 | 894-85-8234 |          | Pl123456 |
      | JAVA   | tarik | olurla  |harika@gmail |          | adana      | gender | 22.04.2000 | 495-057-8874 | 832-25-8954 | umitg    | Pl12     |
      | JAVA   | halil | torn    |hogam        | danisma  | adana      | gender | 22.04.2000 | 999-857-8874 | 384-25-8974 | umitg    | Pl123456 |
      | JAVA   | umit  | toray   |fert@jaa     | danisma  | adana      | gender | 22.04.2000 | 475-855-8874 | 894-85-8974 | umitg    | Pl123456 |


    Scenario:
      Then close the application





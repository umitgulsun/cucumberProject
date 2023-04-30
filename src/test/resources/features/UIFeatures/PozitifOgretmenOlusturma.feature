@sen@gen@hen
Feature: Vice Dean Ogretmen olusturabilmelidir

  Background: :Teacher olarak giris yapar
    Given Kullanici anasayfaya gider
    Given Kullanici Anasayfada logine tiklar
    Given "username" ve "password" girer
    Then  login tusuna tiklar

  Scenario: Ogretmen bilgileri girilerek ogretmen olusturma pozitif test
    Given Kullanici menu butonuna tiklar
    Given Kullanici ogretmen alanina tiklar
    Given dersler alanina ders bilgilerini fake girer
    Given name alanina bilgileri fake girer
    Given surname alanina surname bilgileri fake girer
    Given "email" alanina gecerli bir email girer
    Given danisman alanina danisman bilgileri girer
    Given birthplace alanina birthplace bilgileri girer
    Given gender alanina gender bilgileri girer
    Given birthday alanina birthday bilgileri girer
    Given phone alanina uc-uc-dort rakam seklinde bilgileri girer
    Given ssn alanina uc-iki-dort rakam seklinde bilgileri girer
    Given username alanina username bilgileri girer
    Given password alanina password bilgileri girer
    Then  submit tusuna tiklar
    Then  ogretmenin olustugunu dogrular


  Scenario:Sayfa kapatilir
    Then close the application




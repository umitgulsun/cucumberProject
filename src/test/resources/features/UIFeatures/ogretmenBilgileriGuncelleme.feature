@ten@gen@hen
Feature: Vice Dean öğretmenleri görebilmeli ve güncelleme yapabilmelidir

  Background: :Teacher olarak giris yapar
    Given Kullanici anasayfaya gider
    Given Kullanici Anasayfada logine tiklar
    Given "username" ve "password" girer
    Then  login tusuna tiklar

  Scenario: Ogretmen bilgilerini guncelleme pozitif test
    Given Kullanici menu butonuna tiklar
    Given Kullanici ogretmen alanina tiklar
    Then  daha once olusturulan "125-99-1256" ssn nolu kişi listeden bulunur ve satırdaki edit butonuna tiklar
    Given dersler alanina ders bilgilerini gunceller
    Given name alanini gunceller
    Given surname alanini gunceller
    Given birthplace alanini gunceller
    Given birthday alanini gunceller
    Given gender alanini gunceller
    Given phone alanini gunceller
    Given password alanini gunceller
    Then  submit tusuna basip dogrulama yapar

  Scenario:Sayfa kapatilir
    Then close the application
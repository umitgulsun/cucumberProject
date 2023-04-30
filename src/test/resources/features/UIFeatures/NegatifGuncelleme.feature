@zen@hen
Feature: Vice Dean öğretmenleri görebilmeli ve güncelleme yapabilmelidir

  Background: :Teacher olarak giris yapar
    Given Kullanici anasayfaya gider
    Given Kullanici Anasayfada logine tiklar
    Given "username" ve "password" girer
    Then  login tusuna tiklar


  Scenario Outline: Daha once kaydedilen ogretmen bilgilerinin guncellemesi negatif test
    Given Kullanici menu butonuna tiklar
    Given Kullanici ogretmen alanina tiklar
    Then  daha once olusturulan "894-85-8974" ssn nolu kişi listeden bulunur ve satırdaki edit butonuna tiklar
    Given dersler alanina ders bilgilerini gunceller
    Given "<name>" name alaninigunceller
    Given "<surname>" surname alanini gunceller
    Given "<email>" email alanini gunceller
    Given "<birthplace>" birthplace alanini gunceller
    Given "<birthday>" birthday alanini gunceller
    Given gender alanini gunceller
    Given "<phone>" phone alanini gunceller
    Given "<ssn>" ssn alanini gunceller
    Given "<username>" username alanini gunceller
    Given "<password>" password alanini gunceller
    Then  submit tusuna basip negatif dogrulama yapar


    Examples:
      | name  | surname |email        | birthplace |birthday   | phone        | ssn         | username | password |
      | sadik | olur    |harka@gmail  | adana      |22.04.2000 | 475-8578874  | 899-25-8974 | umitg    | Pl123456 |
      | Fatih | kadar   |hogam@       | adana      |22.04.2000 | 475-837-8874 | 89425-8974  | umitg    | Pl123456 |
      | umit  | halak   |ferfs@jaa    | adana      |22.04.2000 | 275-855-8789 | 894-85-8234 |          | Pl123456 |
      | tarik | olurla  |harika@gmail | adana      |22.04.2000 | 495-057-8874 | 832-258954 | umitg    | Pl127823 |
      | halil | torn    |hogam        | adana      |22.04.2000 | 999-857-8874 | 384-25-8974 | umitg    | Pl123456 |
      | umit  | toray   |fert@jaa     | adana      |22.04.2000 | 475-855-8874 | 894-85-8974 | umitg    | Pl123456 |


Scenario:Sayfa kapatilir
  Given close the application

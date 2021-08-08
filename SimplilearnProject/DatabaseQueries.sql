
create database insureusers2;
use insureusers2;

create table LocationDetails(
Email varchar(30) primary key,
ResidenceType varchar(20),
AddressLine1 varchar(30),
City varchar(15),
State varchar(15),
Zip int,
ResidenceUse varchar(10));

create table HomeOwnerDetails(
EmailAddress varchar(30) primary key,
FirstName varchar(20),
LastName varchar(20),
DateofBirth date,
Areyouretired varchar(3),
SocialSecurityNumber int,
Password varchar(20));

create table PropertyDetails(
Email varchar(30) primary key,
MarketValue varchar(10),
Year int,
SquareFootage varchar(20),
DwellingStyle varchar(10),
RoofMaterial varchar(10),
GarageType varchar(10),
NoOfFullBaths int,
NoOfHalfBaths int,
PoolAvailable varchar(3));

create table QuoteDetails(
QuoteId double primary key auto_increment,
MonthlyPremium double,
DwellingCoverage double,
DetachedStructures double,
PersonalProperty double,
MedicalExpense double,
AdditionalLivingExpense double,
Deductible double);

create table PolicyDetails(
QuoteId double,
PolicyKey int primary key auto_increment,
PolicyEffectiveDate date,
PolicyEndDate date,
PolicyTerm long,
PolicyStatus varchar(10));

create table Policyemail(
PolicyKey int primary key,
Email varchar(30));

create table quoteemail(
QuoteId double primary key,
Email varchar(30));

create table login(
Email varchar(30) primary key,
Password varchar(20),
TypeOfUser varchar(10));
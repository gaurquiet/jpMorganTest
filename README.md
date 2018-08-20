JPMorgan Skill Test!
===================

> **Tip:** This is a maven based Java project. Import it in Java based IDE(Eclipse) as a maven project.

<kbd>com.jpmorgan.setup.ApplicationSetup</kbd>

Above mentioned class is the starting point to run this application. "Run this class as Java"
You will get following log in command line:
```
Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :1
```
Program is reading input from command line so type 1 and press enter button to send an instruction.
```
Add entity name:
foo
```
```
Add instruction type (B for Buy and S for Sell):
B
```
```
Add agreed Fx:
0.5
```
```
Add 3 digit currency code:
SGP
```
```
Add instruction date (dd-mm-yyyy):
01-01-2016
```
```
Add settlement date (dd-mm-yyyy):
02-01-2016
```
```
Add units!
200
```
```
Add price per unit!
100.25
```
>**Entered Instruction:**
>Instruction [entity=foo, instructionType=B, agreedFx=0.5, currency=SGP, instructionDate=Fri Jan 01 00:01:00 IST 2016, settlementDate=Sat Jan 02 00:01:00 IST 2016, updatedSettlementDate=null, units=200, pricePerUnit=100.25, instructionAmountInUSD=0.0, weekDay=null]

----------

> **Saved Instruction:**
> Instruction [entity=foo, instructionType=B, agreedFx=0.5, currency=SGP, instructionDate=Fri Jan 01 00:01:00 IST 2016, settlementDate=Sat Jan 02 00:01:00 IST 2016, updatedSettlementDate=Mon Jan 04 00:01:00 IST 2016, units=200, pricePerUnit=100.25, instructionAmountInUSD=10025.0, weekDay=Sat]

Add few more such instructions:
```
Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :1
```
```
Add entity name:
bar
```
```
Add instruction type (B for Buy and S for Sell):
S
```
```
Add agreed Fx:
0.22
```
```
Add 3 digit currency code:
AED
```
```
Add instruction date (dd-mm-yyyy):
05-01-2016
```
```
Add settlement date (dd-mm-yyyy):
07-01-2016
```
```
Add units!
450
```
```
Add price per unit!
150.5
```
>**Entered Instruction:**
>Instruction [entity=bar, instructionType=S, agreedFx=0.22, currency=AED, instructionDate=Tue Jan 05 00:01:00 IST 2016, settlementDate=Thu Jan 07 00:01:00 IST 2016, updatedSettlementDate=null, units=450, pricePerUnit=150.5, instructionAmountInUSD=0.0, weekDay=null]

----------

> **Saved Instruction:**
> Instruction [entity=bar, instructionType=S, agreedFx=0.22, currency=AED, instructionDate=Tue Jan 05 00:01:00 IST 2016, settlementDate=Thu Jan 07 00:01:00 IST 2016, updatedSettlementDate=Thu Jan 07 00:01:00 IST 2016, units=450, pricePerUnit=150.5, instructionAmountInUSD=14899.5, weekDay=Thu]

----------
```
Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :1
```
```
Add entity name:
bar
```
```
Add instruction type (B for Buy and S for Sell):
S
```
```
Add agreed Fx:
0.22
```
```
Add 3 digit currency code:
AED
```
```
Add instruction date (dd-mm-yyyy):
04-01-2016
```
```
Add settlement date (dd-mm-yyyy):
04-01-2016
```
```
Add units!
450
```
```
Add price per unit!
150.5
```
>**Entered Instruction:**
>Instruction [entity=bar, instructionType=S, agreedFx=0.22, currency=AED, instructionDate=Mon Jan 04 00:01:00 IST 2016, settlementDate=Mon Jan 04 00:01:00 IST 2016, updatedSettlementDate=null, units=450, pricePerUnit=150.5, instructionAmountInUSD=0.0, weekDay=null]

----------

> **Saved Instruction:**
Instruction [entity=bar, instructionType=S, agreedFx=0.22, currency=AED, instructionDate=Mon Jan 04 00:01:00 IST 2016, settlementDate=Mon Jan 04 00:01:00 IST 2016, updatedSettlementDate=Mon Jan 04 00:01:00 IST 2016, units=450, pricePerUnit=150.5, instructionAmountInUSD=14899.5, weekDay=Mon]

```
Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :1
```
```
Add entity name:
adani
```
```
Add instruction type (B for Buy and S for Sell):
B
```
```
Add agreed Fx:
68
```
```
Add 3 digit currency code:
INR
```
```
Add instruction date (dd-mm-yyyy):
07-01-2016
```
```
Add settlement date (dd-mm-yyyy):
07-01-2016
```
```
Add units!
650
```
```
Add price per unit!
37
```
>**Entered Instruction:**
>Instruction [entity=adani, instructionType=B, agreedFx=68.0, currency=INR, instructionDate=Thu Jan 07 00:01:00 IST 2016, settlementDate=Thu Jan 07 00:01:00 IST 2016, updatedSettlementDate=null, units=650, pricePerUnit=37.0, instructionAmountInUSD=0.0, weekDay=null]

----------

> **Saved Instruction:**
> Instruction [entity=adani, instructionType=B, agreedFx=68.0, currency=INR, instructionDate=Thu Jan 07 00:01:00 IST 2016, settlementDate=Thu Jan 07 00:01:00 IST 2016, updatedSettlementDate=Thu Jan 07 00:01:00 IST 2016, units=650, pricePerUnit=37.0, instructionAmountInUSD=1635400.0, weekDay=Thu]

----------
```
Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :
2
```
```
Enter 1 for report on a date, enter 2 to get complete report:
2
```

Entity| Buy/Sell| Agreed Fx | Currency|Instruction Date             |Settelement Date             |Updated Settelement Date               |Units    |Price per Unit     |Total Value in USD    
-------- | --- | ---------- | ------- | --------------------------  | ---------------             | ----------------------                | ------  | ------------      | -----------------
adani    |B         |68.0          |INR           |Thu Jan 07 00:01:00 IST 2016 |Thu Jan 07 00:01:00 IST 2016 |Thu Jan 07 00:01:00 IST 2016           |650      |37.0               |1635400.0                    
bar      |S         |0.22          |AED           |Mon Jan 04 00:01:00 IST 2016 |Mon Jan 04 00:01:00 IST 2016 |Mon Jan 04 00:01:00 IST 2016           |450      |150.5              |14899.5                      
bar      |S         |0.22          |AED           |Tue Jan 05 00:01:00 IST 2016 |Thu Jan 07 00:01:00 IST 2016 |Thu Jan 07 00:01:00 IST 2016           |450      |150.5              |14899.5                      
foo      |B         |0.5           |SGP           |Fri Jan 01 00:01:00 IST 2016 |Sat Jan 02 00:01:00 IST 2016 |Mon Jan 04 00:01:00 IST 2016           |200      |100.25             |10025.0 


```
Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :2
```
```
Enter 1 for report on a date, enter 2 to get complete report:
1
```
```
Enter date  (dd-mm-yyyy):
04-01-2016
```
```
Incoming amount on date Mon Jan 04 00:01:00 IST 2016 : 14899.5
Outgoing amount on date Mon Jan 04 00:01:00 IST 2016 : 10025.0
```

Entity| Buy/Sell| Agreed Fx | Currency|Instruction Date             |Settelement Date             |Updated Settelement Date               |Units    |Price per Unit     |Total Value in USD    
-------- | --- | ---------- | ------- | --------------------------  | ---------------             | ----------------------                | ------  | ------------      | -----------------
bar      |S         |0.22          |AED           |Mon Jan 04 00:01:00 IST 2016 |Mon Jan 04 00:01:00 IST 2016 |Mon Jan 04 00:01:00 IST 2016           |450      |150.5              |14899.5                      
|foo      |B         |0.5           |SGP           |Fri Jan 01 00:01:00 IST 2016 |Sat Jan 02 00:01:00 IST 2016 |Mon Jan 04 00:01:00 IST 2016           |200      |100.25             |10025.0                      


```
Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :2
```
```
Enter 1 for report on a date, enter 2 to get complete report:
1
```
```
Enter date  (dd-mm-yyyy):
07-01-2016
```
```
Incoming amount on date Thu Jan 07 00:01:00 IST 2016 : 14899.5
Outgoing amount on date Thu Jan 07 00:01:00 IST 2016 : 1635400.0
```

Entity| Buy/Sell| Agreed Fx | Currency|Instruction Date             |Settelement Date             |Updated Settelement Date               |Units    |Price per Unit     |Total Value in USD    
-------- | --- | ---------- | ------- | --------------------------  | ---------------             | ----------------------                | ------  | ------------      | -----------------
adani    |B         |68.0          |INR           |Thu Jan 07 00:01:00 IST 2016 |Thu Jan 07 00:01:00 IST 2016 |Thu Jan 07 00:01:00 IST 2016           |650      |37.0               |1635400.0                    
bar      |S         |0.22          |AED           |Tue Jan 05 00:01:00 IST 2016 |Thu Jan 07 00:01:00 IST 2016 |Thu Jan 07 00:01:00 IST 2016           |450      |150.5              |14899.5                      


```
Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :                
```
```
Thanks for using application !! Good bye !! Exit!
```
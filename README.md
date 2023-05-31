# Втора лабораториска вежба по Софтверско Инженерство

# SI_2023_lab2_213031 Дамјан Аврамовски 213031

# 2. За дадениот код во функцијата function нацртајте Control Flow Graph со некоја  алатка за цртање дијаграми. Внесете го нацртанот CFG во документацијата.
![CFG drawio](https://github.com/Gavranot/SI_2023_lab2_213031/assets/127050536/7786b8db-909d-4104-9f73-402e24461980)

# 3. Пресметајте ја цикломатската комплексност на дадениот код. Објаснете како стигнавте до резултатот.
Цикломатската комплексност на дадениот код изнесува 11 и може да се пресмета преку формулата P+1 каде бројот P е бројот на предикатни јазли, кој изнесува 10.

# 4. и 5. Напишете ги сите тест случаи според Every Branch критериумот. Напишете и објаснете ги тест случаите во документацијата. Напишете ги сите тест случаи според Multiple Condition критериумот за условот if (user==null || user.getPassword()==null || user.getEmail()==null). Напишете и објаснете ги тест случаите во документацијата.

Секој тест случај е напишан како негација, односно дали лозинката содржи празно место или не содржи празно место. Според every branch критериумот, се земаа сите предикатни јазли и во однос на нив се конструира оваа табела:[SI_lab2_213031.xlsx](https://github.com/Gavranot/SI_2023_lab2_213031/files/11618520/SI_lab2_213031.xlsx)
Во табелата има втор sheet каде што е поставена табела за multiple conditions критериумот со тоа што се врши lazy evaluation.

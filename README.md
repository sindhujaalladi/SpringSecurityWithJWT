# SpringSecurityWithJWT
here i am implementing JWT authenthication with spring security .
![image](https://user-images.githubusercontent.com/115841974/204066507-09213135-14dd-43a6-a58c-02ac1a9b52a7.png)


now i got jwt token with this token i will add in header section and add the data in data base
![image](https://user-images.githubusercontent.com/115841974/204066744-a566846c-176a-4e18-9144-4e1174623097.png)


with the same token i will get data from db 
![image](https://user-images.githubusercontent.com/115841974/204066756-0295e9ac-aeee-45a2-8262-884c80080cf4.png)


here i have used inmemmoryauthenthication mnager in order to generate token 


if i use db validate the credentails i am getting below error 
![image](https://user-images.githubusercontent.com/115841974/204066789-0f75ff06-7cd6-428f-90a2-9f4a04445360.png)

if u use bcrypted format of password and length of password should be 60 then the user credentals will be validated 

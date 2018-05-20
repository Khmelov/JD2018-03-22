//"батник" от bat
FOR %%I In (*.txt) DO (
//
//C:\Programs Files\Java\jdk.8.0_151
//D:\Programs\Java8\jdk1.8.0_171
"D:\Programs\Java8\jdk1.8.0_171\bin\native2ascii" -encoding utf-8 %%I ..\ok\%%-nI.properties/
)
//"C:\Programs Files\Java\jdk.8.0_151\bin\native2ascii" -encoding utf-8 msg.txt ..\ok\msg.properties
//для каждого файла txt
<?php
$servername = "sylvester-mccoy-v3:3306/";
$username = "inf124grp31";
$password = "bRU@Eph2";
$database = "inf124grp31";
// Create connection
try {
    $conn = new PDO("mysql:host=$servername;dbname=inf124grp31", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    echo "Connected successfully"; 
    }
catch(PDOException $e)
    {
    echo "Connection failed: " . $e->getMessage();
    }


?>
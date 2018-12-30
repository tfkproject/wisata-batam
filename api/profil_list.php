<?php
// array for JSON response
$response = array();
// include db connect class
require 'connection.php';

if($result = $db->query("SELECT * FROM tbl_profil")){
    	if($count = $result->num_rows){
    		$response["field"] = array();
    		
    		while($row = $result->fetch_object()){
    			$data = array();
    			$data["id_profil"] = $row->id_profil;
    			$data["nama"] = $row->nama;
    			$data["konten"] = $row->konten;
    			
    			array_push($response["field"], $data);
    		}
    		
    		$response["success"] = 1;
    		
    		// echoing JSON response
    		echo json_encode($response);
    	}
    	else{
    	    // no datas found
            $response["success"] = 0;
            $response["message"] = "Maaf, data tidak ada";
            // echo no users JSON
            echo json_encode($response);
    	}
    		
    		$result->free();
    }
    else {
        // no datas found
        $response["success"] = 0;
        $response["message"] = "Maaf, terdapat error pada database";
        // echo no users JSON
        echo json_encode($response);
    }
?>

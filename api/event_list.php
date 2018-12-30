<?php
// array for JSON response
$response = array();
// include db connect class
require 'connection.php';

if($result = $db->query("select * from tbl_event order by id_event desc")){
    	if($count = $result->num_rows){
    		$response["field"] = array();
    		$nomor=1;
    		while($row = $result->fetch_object()){
    			$data = array();
				$data['no'] = "".$nomor++;
				$data["id_event"] = $row->id_event;
    			$data["tanggal"] = $row->tanggal;
    			$data["event"] = $row->event;
    			
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

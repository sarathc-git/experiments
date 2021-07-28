import http from 'k6/http';
import { sleep } from 'k6';

export default function () {
    var url = 'http://localhost:8080/v0.1/GreetingRequest';
    
    var payload = JSON.stringify({
      'name': "Sarath",
      'locale': 'en-in'
    });
    var params = {
      headers : {
        'Accept' : 'text/plain',
        'Content-Type' : 'application/json',
        'ContentType' : 'application/json'
      }
    };

    let res = http.post(url, payload, params);
    
    console.log (res.status + ' : ' + res.body);
    
    sleep(1);
  }
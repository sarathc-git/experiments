import http from 'k6/http';
import { sleep } from 'k6';

export default function () {
  http.get('http://localhost:8080/v0.5/');
  sleep(1);
}

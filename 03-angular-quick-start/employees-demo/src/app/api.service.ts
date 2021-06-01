// tslint:disable: no-any

import {Injectable} from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class ApiService {

    constructor(private http: HttpClient) {

    }

    get(path: string, params: HttpParams = new HttpParams()): Observable<any> {
        return this.http.get(`${environment.apiUrl}${path}`, {params});
    }

    patch(path: string, body: any): Observable<any> {
        return this.http.patch(`${environment.apiUrl}${path}`, body);
    }
}

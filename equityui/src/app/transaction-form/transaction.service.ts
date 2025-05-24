
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Trade } from './trade.model';

@Injectable({ providedIn: 'root' })
export class TradeService {
  private baseUrl = 'http://localhost:8080/api/trades';

  constructor(private http: HttpClient) {}

  createTrade(trade: Trade) {
    return this.http.post(this.baseUrl, trade);
  }

  getPositions(transactionId: string) {
    return this.http.get(`${this.baseUrl}/positions/${transactionId}`);
  }
}

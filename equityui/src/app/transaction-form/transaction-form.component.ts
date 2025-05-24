
import { Component } from '@angular/core';
import { TransactionService } from './transaction.service';
import { Trade } from './trade.model';

@Component({
  selector: 'app-transaction-form',
  templateUrl: './transaction-form.component.html'
})
export class TradeFormComponent {
  trade: Trade = {
    transactionId: '',
    tradeId: 0,
    version: 1,
    symbol: '',
    quantity: 0,
    price: 0,
    action: 'BUY'
  };

  positions: any[] = [];

  constructor(private tradeService: TradeService) {}

  submit() {
    this.tradeService.createTrade(this.trade).subscribe(() => {
      this.loadPositions();
    });
  }

  loadPositions() {
    this.tradeService.getPositions(this.trade.transactionId).subscribe(data => {
      this.positions = data as any[];
    });
  }
}


export interface Transaction {
  transactionId: string;
  tradeId: number;
  version: number;
  symbol: string;
  quantity: number;
  action: 'BUY' | 'SELL';
}

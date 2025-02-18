# Periods

For bookkeeping purposes, the settlement includes an overview of transactions included in the settlement. These transactions are grouped into 'period' objects — one for each calendar month.

For example, if a settlement includes funds from 15 April until 4 May, it will include two period objects. One for all transactions processed between 15 April and 30 April, and one for all transactions between 1 May and 4 May.

Period objects are grouped by year, and then by month. So in the above example, the full `periods` collection will look as follows: `{"2024": {"04": {...}, "05": {...}}}`.

Each period object will contain the following fields:
* `revenue` — An array of revenue objects containing the total revenue for each payment method during this period
* `costs` — An array of cost objects, describing the fees withheld for each payment method during this period
* `invoiceId` — The ID of the invoice created for this period, if the invoice has been created yet

Each `revenue` object has the following fields:
* `description` — A description of the revenue subtotal
* `method` — The payment method, if applicable
* `count` — The number of payments
* `amountNet` — The net total of received funds, i.e. excluding VAT
* `amountVat` — The applicable VAT
* `amountGross` — The gross total of received funds, i.e. including VAT

Each `cost` object has the following fields:
* `description` — A description of the cost subtotal
* `method` — The payment method, if applicable
* `count` — The number of fees
* `rate` — The service rates, further divided into `fixed` and `percentage` costs
* `amountNet` — The net total cost, i.e. excluding VAT
* `amountVat` — The applicable VAT
* `amountGross` — The gross total cost, i.e. including VAT

The example response should give a good idea of what this looks like in practise.


## Fields

| Field       | Type        | Required    | Description |
| ----------- | ----------- | ----------- | ----------- |
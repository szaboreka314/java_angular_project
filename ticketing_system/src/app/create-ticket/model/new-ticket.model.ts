export class NewTicket {
  constructor(public name: string, public details: string, public priority: number, public category: string, public createdAt: Date, public resolution: string, public status: string) {
  }
}

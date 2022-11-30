export class NewTicket {
  constructor(public name: string, public details: string, public priority: number, public category: string, public assignee: number, public created_by: number) {
  }
}

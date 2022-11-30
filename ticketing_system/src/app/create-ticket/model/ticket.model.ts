export class Ticket {
  public id:number;
  public name:string;
  public description: string;
  public created_at: Date;
  public created_by: number;
  public assignee: number;
  public priority: number;
  public category: string;
  public status: string;
  public resolution: string;
  constructor(id: number, name:string, description: string, created_at: Date, created_by:number, assignee:number, priority:number, status:string, resolution:string, category:string){
    this.id = id;
    this.name = name;
    this.description = description;
    this.created_at = created_at;
    this.created_by = created_by;
    this.assignee = assignee;
    this.priority = priority;
    this.category = category;
    this.status = status;
    this.resolution = resolution;
  }
}

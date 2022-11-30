import {AbstractControl, NG_VALIDATORS, ValidationErrors, Validator, ValidatorFn} from "@angular/forms";
import {Directive} from "@angular/core";
import {ResultType} from "../model/result-type";

@Directive({
  selector: '[appNewTicketValidator]',
  providers: [{ provide: NG_VALIDATORS, useExisting:
    NewTicketValidatorDirective, multi: true }]
})
export class NewTicketValidatorDirective implements Validator {
  validate(control: AbstractControl): ValidationErrors | null {
    return newTicketValidator(control);
  }
}


export const newTicketValidator: ValidatorFn = (control: AbstractControl):
  ValidationErrors | null => {
  const resultType = control.get('result-type');
  switch (resultType?.value){
    case ResultType.OK:
      return resultType?.value == "ok" ? null : { resultInvalid: true};
  }
  return null;
};

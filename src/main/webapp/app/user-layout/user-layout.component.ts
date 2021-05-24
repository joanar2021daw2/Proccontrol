import { Component, OnInit, TemplateRef } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

/**
 * Aquesta classe serveix per administrar model personalitzat
 */
@Component({
  selector: 'app-user-layout',
  templateUrl: './user-layout.component.html',
  styleUrls: ['./user-layout.component.css']
})
export class UserLayoutComponent {
  title = 'proccontrol';
  public isMenuCollapsed = true;
  closeResult = '';

  constructor(private modalService: NgbModal) { }


  openModal(template: TemplateRef<any>) {
    this.modalService.open(template, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  /**
   * Forma de tancar modal
   * @param reason si es per teclat, clicant boto o altres
   * @returns un motiu
   */
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
}

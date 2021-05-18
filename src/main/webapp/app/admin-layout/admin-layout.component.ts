import { Component, TemplateRef } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-admin-layout',
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.css']
})
/**
 * Aquesta classe serveix per crear MODAL, utilitzem per menu hamburger, quan el dispositiu és mòvil, tablet ...
 */
export class AdminLayoutComponent {
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
   * Tancar el modal
   * @param reason Motiu de tancar el modal
   * @returns Motiu
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

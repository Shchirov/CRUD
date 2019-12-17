import React from "react";

export class Row extends React.Component {

    constructor(props) {
        super(props);
        this.state = {edit: this.props.id < 0};
        this.textarea = null;
        this.edit = this.edit.bind(this);
        this.removeRow = this.removeRow.bind(this);
        this.edit = this.edit.bind(this)
    }

    componentDidMount() {
        if (this.state.edit) {
            this.refs.input.focus();
        }
    }

    componentDidUpdate() {
        if (this.state.edit) {
            this.refs.input.focus();
        }
    }

    edit() {
        this.setState({edit: true});
    }

    save() {
        this.setState({edit: false, changed: this.refs.input.value !== this.props.text});
        this.props.textUpdate(this.props.id, this.refs.input.value);
    }

    removeRow() {
        var updateHandler = this.props.remove;
        var id = this.props.id;
        if (id > 0) {
            fetch('http://localhost:7070/message/' + this.props.id, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                }
            })
                .then(res => res.text())
                .then(res => {
                    updateHandler(id);
                });
        }

        updateHandler(id);
    }

    render() {
        if (!this.state.edit) {
            this.textarea = <span className="row-text">{this.props.text}</span>;
        } else {
            this.textarea =
                <input className="row-edit" placeholder="Enter text" type="text" onBlur={this.save.bind(this)}
                       defaultValue={this.props.text} ref="input"/>;
        }
        let classValue = "row";
        if (this.props.changed)
            classValue += " changed";
        return (
            <div className={classValue} onClick={this.edit}>
                {this.textarea}
                <button className="remove" onClick={this.removeRow}>×</button>
            </div>
        )
    }
}
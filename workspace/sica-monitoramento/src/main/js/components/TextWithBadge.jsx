import React from 'react';

import Badge from 'react-bootstrap/Badge';

class TextWithBadge extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            text: props.text,
            badgeText: props.badgeText,
            badgeVariant: props.badgeVariant,
            badgeTitle: props.badgeTitle
        };
    }

    render() {
        return (
            <>
                {this.state.text} <Badge variant={this.state.badgeVariant} title={this.state.badgeTitle}>{this.state.badgeText}</Badge>
            </>
        );
    }
}

export default TextWithBadge;
